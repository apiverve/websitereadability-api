# Website Readability API - PHP Package

Website Readability analyzes live web pages to score their reading difficulty and educational grade level. It returns Flesch Reading Ease, Flesch-Kincaid grade level, word count, sentence count, and estimated reading time.

## Installation

Install via Composer:

```bash
composer require apiverve/websitereadability
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Websitereadability\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['url' => 'https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Websitereadability\Client;
use APIVerve\Websitereadability\Exceptions\APIException;
use APIVerve\Websitereadability\Exceptions\ValidationException;

try {
    $response = $client->execute(['url' => 'https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts']);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/websitereadability?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/websitereadability?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/websitereadability?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
