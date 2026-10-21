# Moonrise Moonset API - PHP Package

Moonrise Moonset calculates exact moonrise and moonset times for any geographic coordinate. It outputs ISO 8601 timestamps for lunar rise and set events, with paid plans adding moon phase details and date selection.

## Installation

Install via Composer:

```bash
composer require apiverve/moonrisemoonset
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Moonrisemoonset\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'lat' => 37.7749,
    'lon' => -122.4194,
    'date' => '01-16-2026'
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Moonrisemoonset\Client;
use APIVerve\Moonrisemoonset\Exceptions\APIException;
use APIVerve\Moonrisemoonset\Exceptions\ValidationException;

try {
    $response = $client->execute(['lat' => 37.7749, 'lon' => -122.4194, 'date' => '01-16-2026']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/moonrisemoonset?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/moonrisemoonset?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/moonrisemoonset?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
