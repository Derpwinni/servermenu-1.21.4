# ServerMenu

![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21.x-brightgreen)
![Fabric API](https://img.shields.io/badge/Fabric%20API-Required-blue)

A lightweight Fabric mod for Minecraft 1.21.x that enhances the multiplayer server list by remembering your scroll position and selected server. Perfect for players who frequently switch between servers!

## 🚀 Features

- **Persistent Server Selection**: When returning to the multiplayer screen, your previously selected server remains highlighted.
- **Scroll Position Memory**: Retains your scroll position in long server lists, so you don't have to scroll down every time.
- **Toggle Button**: Conveniently placed button in the bottom-left corner of the multiplayer screen to enable/disable the mod's functionality.
- **Compatibility Focused**: Designed to work harmoniously with other mods.
- **Lightweight**: Minimal impact on performance with no external dependencies beyond Fabric API.

## 📋 Requirements

- Minecraft 1.21.x
- Fabric Loader >=0.16.14
- Fabric API
- Java 21 or higher

## 💾 Installation

1. Install [Fabric Loader](https://fabricmc.net/use/) and [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api)
2. Download the latest ServerMenu mod JAR from the [Releases](https://github.com/Derpwinni/servermenu-1.21.4/releases) page
3. Place the JAR file in your Minecraft `mods` folder
4. Launch Minecraft with the Fabric profile and enjoy!

## 🎮 Usage

- The mod works automatically once installed
- Toggle the functionality ON/OFF using the "SM" button in the bottom-left corner of the multiplayer screen
- When enabled, your server selection and scroll position will be remembered between sessions

## 🧩 Compatibility

ServerMenu is designed to be compatible with most other Fabric mods. If you encounter any compatibility issues, please report them on the [Issues](https://github.com/Derpwinni/servermenu-1.21.4/issues) page.

## 🔧 For Developers

### Building from Source

```bash
git clone https://github.com/Derpwinni/servermenu-1.21.4.git
cd ServerMenu
./gradlew build
```

The compiled JAR will be in `build/libs/`.

### Project Structure

- `src/main/java/`: Core mod files
- `src/client/java/`: Client-side implementation
- `src/client/java/com/kevin/server/mixin/`: Mixins for UI modifications

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/amazing-feature`
3. Commit your changes: `git commit -m 'Add some amazing feature'`
4. Push to your branch: `git push origin feature/amazing-feature`
5. Open a Pull Request

Please ensure your code follows the existing style and includes appropriate documentation.

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 💖 Acknowledgments

- Thanks to the Fabric community for their excellent modding framework
- All contributors who help improve this mod
