# Moonrise Moonset API - Dart/Flutter Client

Moonrise Moonset calculates exact moonrise and moonset times for any geographic coordinate. It outputs ISO 8601 timestamps for lunar rise and set events, with paid plans adding moon phase details and date selection.

[![pub package](https://img.shields.io/pub/v/apiverve_moonrisemoonset.svg)](https://pub.dev/packages/apiverve_moonrisemoonset)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Moonrise Moonset API](https://apiverve.com/marketplace/moonrisemoonset?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_moonrisemoonset: ^1.2.5
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_moonrisemoonset/apiverve_moonrisemoonset.dart';

void main() async {
  final client = MoonrisemoonsetClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'lat': 37.7749,
      'lon': -122.4194,
      'date': '01-16-2026'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "coordinates": {
      "latitude": 37.7749,
      "longitude": -122.4194
    },
    "phase": "Waning Crescent",
    "moonrise": "2025-12-16T12:24:41.532Z",
    "moonset": "2025-12-16T22:22:04.027Z",
    "moonAlwaysUp": false,
    "moonAlwaysDown": false
  }
}
```

## API Reference

- **API Home:** [Moonrise Moonset API](https://apiverve.com/marketplace/moonrisemoonset?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/moonrisemoonset](https://docs.apiverve.com/ref/moonrisemoonset?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
