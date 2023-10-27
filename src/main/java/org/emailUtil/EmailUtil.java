package org.emailUtil;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import java.util.Properties;

public class EmailUtil {

    public static void check(String host, String storeType, String user, String password) {
        try {

            // create properties
            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            properties.put("mail.imap.ssl.trust", host);

            Session emailSession = Session.getDefaultInstance(properties);

            // create the imap store object and connect to the imap server
            Store store = emailSession.getStore("imaps");

            store.connect(host, user, password);

            // create the inbox object and open it
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);
            MessageReader messageReader = new MessageReader();
            String[] msgArr = new String[3];
            // retrieve the messages from the folder in an array and print it
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
            System.out.println("messages.length---" + messages.length);
            int n = messages.length;
            for (int i = n-1;  i >= 0; i--) {
                Message message = messages[i];
                message.setFlag(Flags.Flag.SEEN, true);
                if(message.getFrom()[0].toString().contains("naukri.com")) {
                    System.out.println("---------------------------------");
                    System.out.println("Email Number " + (i + 1));
                    System.out.println("Received Date: " + message.getReceivedDate());
                    System.out.println("Subject: " + message.getSubject());
                    System.out.println("From: " + message.getFrom()[0]);
                    System.out.println("Text2: " + messageReader.getTextFromMessage(message));
                    msgArr[0] = message.getReceivedDate().toString();
                    msgArr[1] = message.getSubject();
                    msgArr[2] = message.getFrom()[0].toString();
                    msgArr[3] = messageReader.getTextFromMessage(message);
                }
            }

            inbox.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String host = "imap.gmail.com";
        String mailStoreType = "imap";
        String username = "subhajitbhattacharjee007@gmail.com";
        String password = "bkht hdtw hmwu ruuk";
        check(host, mailStoreType, username, password);
    }
}
