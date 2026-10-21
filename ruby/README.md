# Website Readability API - Ruby Gem

Website Readability analyzes live web pages to score their reading difficulty and educational grade level. It returns Flesch Reading Ease, Flesch-Kincaid grade level, word count, sentence count, and estimated reading time.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_websitereadability'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_websitereadability
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_websitereadability'

# Initialize the client
client = APIVerve::Websitereadability::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ url: "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ url: "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts" })
  puts response["data"]
rescue APIVerve::Websitereadability::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Websitereadability::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Websitereadability::Client.new(
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
    "fleschReadingEase": 24.34,
    "fleschReadingEaseText": "Very Confusing",
    "fleschKincaidGrade": 19.3,
    "gunningFog": 19.62,
    "colemanLiauIndex": 13.12,
    "smogIndex": 14.37,
    "automatedReadabilityIndex": 22.6,
    "daleChallReadabilityScore": 17,
    "daleChallReadabilityScoreText": "average 13th to 15th-grade (college) student",
    "wordCount": 634,
    "sentenceCount": 29,
    "readingTimeMinutes": 3,
    "averageGradeLevel": 17.8,
    "targetAudience": "post-graduate",
    "url": "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts"
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/websitereadability?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/websitereadability?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/websitereadability?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
