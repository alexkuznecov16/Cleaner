# File Cleaner Utility

A lightweight Java automation tool that organizes messy directories (like your Downloads folder) into categorized subfolders based on file extensions.

![Java](https://img.shields.io/badge/Java-23-orange?style=for-the-badge&logo=openjdk)
![Platform](https://img.shields.io/badge/Platform-Cross__Platform-blue?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

---

## 📂 Features

- **Smart Categorization** Automatically groups files into 13+ specialized folders including *Photos, Videos, Music, Documents, Archives, Programs, Code, Books, 3D Design, Fonts, Disk Images, Databases/Backups, and Torrents*.

- **Interactive UI** Built-in `JFileChooser` lets users safely navigate and select any custom folder manually, defaulting straight to the user's local `Downloads` directory if no selection is made.

- **Developer Footer Accessory** Features an integrated interactive HTML panel within the dialog box linking directly to active support channels.

- **🛡 Safe Cleaning** The app safely skips:
    - Hidden system files
    - Active Microsoft Office temporary lock files (`~$`)
    - Subdirectories and existing categorical folders

- **⚡ Fast & Lightweight** Zero external dependencies. Powered entirely by native Java Swing and NIO libraries.

---

## 📥 Download

### Latest Release

👉 [Download Cleaner.exe](https://github.com/alexkuznecov16/Cleaner/releases/download/v1.0/Cleaner.exe)

---

## 🚀 How to Run

### Option 1: Double Click
If Java Runtime Environment (JRE) is associated with your system GUI:
1. Download the `Downloads.Cleaner.jar`.
2. Double-click the file.
3. Select your target directory inside the popup interface and confirm.

### Option 2: Command Line / Terminal
Run the application explicitly from your terminal:
```java -jar Downloads.Cleaner.jar```

---

## 🗂 Supported File Types

| Category | Supported Extensions |
| :--- | :--- |
| **Photos** | `jpg`, `jpeg`, `png`, `gif`, `webp`, `svg`, `bmp`, `ico`, `tiff`, `heic`, `raw`, `psd`, `ai` |
| **Videos** | `mp4`, `mkv`, `avi`, `mov`, `wmv`, `flv`, `webm`, `mpeg`, `3gp`, `m4v` |
| **Music** | `mp3`, `wav`, `flac`, `aac`, `ogg`, `m4a`, `wma`, `amr`, `mid` |
| **Documents** | `pdf`, `docx`, `doc`, `xlsx`, `xls`, `pptx`, `ppt`, `txt`, `rtf`, `odt`, `ods`, `odp`, `csv` |
| **Archives** | `zip`, `rar`, `7z`, `tar`, `gz`, `bz2`, `iso`, `dmg` |
| **Programs** | `exe`, `msi`, `apk`, `bat`, `cmd`, `sh`, `app` |
| **Code** | `java`, `jar`, `class`, `py`, `js`, `ts`, `html`, `css`, `json`, `xml`, `c`, `cpp`, `cs`, `php`, `yaml`, `yml`, `ini`, `conf`, `config`, `log`, `md` |
| **Books** | `epub`, `fb2`, `mobi`, `djvu` |
| **3D Design** | `obj`, `fbx`, `stl`, `3ds`, `max`, `blend`, `fig` |
| **Fonts** | `ttf`, `otf`, `woff`, `woff2`, `eot`, `fon` |
| **Disk Images** | `iso`, `vmdk`, `vdi`, `qcow2`, `ova`, `ovf`, `img`, `toast`, `vhd`, `vhdx` |
| **Databases & Backups** | `sql`, `db`, `sqlite`, `mdb`, `accdb`, `bak`, `backup`, `dump` |
| **Torrents** | `torrent` |
| **Other** | Catchment folder for any unknown, unrecognized, or extensionless files. |

---

## 👤 Developer & Support

- **Developer:** Aleksandrs Kuznecovs
- **GitHub:** [@alexkuznecov16](https://github.com/alexkuznecov16)
- **Telegram:** [@kznws111](https://t.me/kznws111)

---
*© 2026 Aleksandrs Kuznecovs. All rights reserved.*