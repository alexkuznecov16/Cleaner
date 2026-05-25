import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.event.HyperlinkEvent;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

class FileGroupIdentifier {
    private static final Map<String, String> EXTENSION_MAP = new HashMap<>();

    static {
        // Photos
        String[] photos = {"jpg", "jpeg", "png", "gif", "webp", "svg", "bmp", "ico", "tiff", "heic", "raw", "psd", "ai"};
        for (String ext : photos) EXTENSION_MAP.put(ext, "Photos");

        // Videos
        String[] videos = {"mp4", "mkv", "avi", "mov", "wmv", "flv", "webm", "mpeg", "3gp", "m4v"};
        for (String ext : videos) EXTENSION_MAP.put(ext, "Videos");

        // Music
        String[] music = {"mp3", "wav", "flac", "aac", "ogg", "m4a", "wma", "amr", "mid"};
        for (String ext : music) EXTENSION_MAP.put(ext, "Music");

        // Documents
        String[] docs = {"pdf", "docx", "doc", "xlsx", "xls", "pptx", "ppt", "txt", "rtf", "odt", "ods", "odp", "csv"};
        for (String ext : docs) EXTENSION_MAP.put(ext, "Documents");

        // Archives
        String[] archives = {"zip", "rar", "7z", "tar", "gz", "bz2", "iso", "dmg"};
        for (String ext : archives) EXTENSION_MAP.put(ext, "Archives");

        // Programs
        String[] programs = {"exe", "msi", "apk", "bat", "cmd", "sh", "app"};
        for (String ext : programs) EXTENSION_MAP.put(ext, "Programs");

        // Code
        String[] code = {"java", "jar", "class", "py", "js", "ts", "html", "css", "json", "xml", "c", "cpp", "cs", "php", "yaml", "yml", "ini", "conf", "config", "log", "md"};
        for (String ext : code) EXTENSION_MAP.put(ext, "Code");

        // Books
        String[] books = {"epub", "fb2", "mobi", "djvu"};
        for (String ext : books) EXTENSION_MAP.put(ext, "Books");

        // 3D_Design
        String[] design = {"obj", "fbx", "stl", "3ds", "max", "blend", "fig"};
        for (String ext : design) EXTENSION_MAP.put(ext, "3D_Design");

        // Fonts
        String[] fonts = {"ttf", "otf", "woff", "woff2", "eot", "fon"};
        for (String ext : fonts) EXTENSION_MAP.put(ext, "Fonts");

        // Disk Images & Virtual Machines
        String[] diskImages = {"iso", "vmdk", "vdi", "qcow2", "ova", "ovf", "img", "toast", "vhd", "vhdx"};
        for (String ext : diskImages) EXTENSION_MAP.put(ext, "Disk_Images");

        // Databases and Backups
        String[] dbBackups = {"sql", "db", "sqlite", "mdb", "accdb", "bak", "backup", "dump"};
        for (String ext : dbBackups) EXTENSION_MAP.put(ext, "Databases_Backups");

        // Torrents
        String[] torrents = {"torrent"};
        for (String ext : torrents) EXTENSION_MAP.put(ext, "Torrents");
    }

    public String getTargetFolder(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');

        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) return "Other";

        String extension = filename.substring(lastDotIndex + 1).toLowerCase();
        return EXTENSION_MAP.getOrDefault(extension, "Other");
    }
}

public class Main {
    public static void main(String[] args) {
        String developerName = "Aleksandrs Kuznecovs";
        String githubUrl = "https://github.com/alexkuznecov16";
        String telegramUrl = "https://t.me/kznws111";

        String home = System.getProperty("user.home");
        Path defaultPath = Paths.get(home, "Downloads");
        File targetFolderToClean = defaultPath.toFile();

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select a folder to clean");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setCurrentDirectory(defaultPath.toFile());

        // --- UPDATED HTML FOOTER (Links are now stacked vertically) ---
        String htmlFooter = "<html><body style='font-family: Arial; font-size: 10px; text-align: center;'>"
                + "<hr style='border: 0; border-top: 1px solid #ccc; margin: 5px 0;'>"
                + "<b>GitHub:</b> <a href='" + githubUrl + "'>" + githubUrl + "</a><br>"
                + "<b>Telegram:</b> <a href='" + telegramUrl + "'>" + telegramUrl + "</a><br>"
                + "<span style='color: gray; display: inline-block; margin-top: 3px;'>&copy; 2026 " + developerName + ". All rights reserved.</span>"
                + "</body></html>";

        JEditorPane footerPane = new JEditorPane("text/html", htmlFooter);
        footerPane.setEditable(false);
        footerPane.setBackground(new JLabel().getBackground());

        footerPane.addHyperlinkListener(e -> {
            if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI(e.getURL().toString()));
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JPanel accessoryPanel = new JPanel(new BorderLayout());
        accessoryPanel.add(footerPane, BorderLayout.SOUTH);

        chooser.setAccessory(accessoryPanel);
        // --------------------------------------------------------------

        int response = chooser.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            targetFolderToClean = chooser.getSelectedFile();
            System.out.println("Selected folder: " + targetFolderToClean.getAbsolutePath());
        } else {
            System.out.println("Selection cancelled. Using default folder: " + targetFolderToClean.getAbsolutePath());
        }

        if (targetFolderToClean.exists() && targetFolderToClean.isDirectory()) {
            File[] allFiles = targetFolderToClean.listFiles();

            FileGroupIdentifier identifier = new FileGroupIdentifier();

            if (allFiles != null) {
                for (File file : allFiles) {
                    if (!file.isHidden() && !file.getName().startsWith("~$") && file.isFile()) {

                        String group = identifier.getTargetFolder(file.getName());
                        File subFolder = new File(targetFolderToClean, group);

                        if (!subFolder.exists()) {
                            boolean created = subFolder.mkdirs();
                            if (created) {
                                System.out.println("New folder created: " + subFolder.getName());
                            }
                        }

                        Path sourcePath = file.toPath();
                        Path targetPath = subFolder.toPath().resolve(file.getName());

                        try {
                            Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("File: " + file.getName() + " ---> Folder: " + group);
                        } catch (IOException e) {
                            System.err.println("Failed to move file " + file.getName() + ": " + e.getMessage());
                        }
                    }
                }
            }
            System.out.println("\nCleaning completed for: " + targetFolderToClean.getName());
        } else {
            System.out.println("Target folder not found.");
        }
    }
}