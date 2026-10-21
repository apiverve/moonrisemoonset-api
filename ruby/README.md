# Moonrise Moonset API - Ruby Gem

Moonrise Moonset calculates exact moonrise and moonset times for any geographic coordinate. It outputs ISO 8601 timestamps for lunar rise and set events, with paid plans adding moon phase details and date selection.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_moonrisemoonset'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_moonrisemoonset
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_moonrisemoonset'

# Initialize the client
client = APIVerve::Moonrisemoonset::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  lat: 37.7749,
  lon: -122.4194,
  date: "01-16-2026"
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ lat: 37.7749, lon: -122.4194, date: "01-16-2026" })
  puts response["data"]
rescue APIVerve::Moonrisemoonset::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Moonrisemoonset::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Moonrisemoonset::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/moonrisemoonset?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/moonrisemoonset?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/moonrisemoonset?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
