# Website Readability API - Go Client

Website Readability is a simple tool for analyzing the readability of a website. It returns the readability score of the website provided.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Go client for the [Website Readability API](https://apiverve.com/marketplace/websitereadability?utm_source=go&utm_medium=readme)

---

## Installation

```bash
go get github.com/apiverve/websitereadability-api/go
```

---

## Configuration

Before using the Website Readability API client, you need to obtain your API key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=go&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=go&utm_medium=readme)

The Website Readability API documentation is found here: [https://docs.apiverve.com/ref/websitereadability](https://docs.apiverve.com/ref/websitereadability?utm_source=go&utm_medium=readme)

---

## Usage

```go
package main

import (
    "fmt"
    "log"

    "github.com/apiverve/websitereadability-api/go"
)

func main() {
    // Create a new client
    client := websitereadability.NewClient("YOUR_API_KEY")

    // Set up parameters
    params := map[string]interface{}{
        "url": "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts"
    }

    // Make the request
    response, err := client.Execute(params)
    if err != nil {
        log.Fatal(err)
    }

    fmt.Printf("Status: %s\n", response.Status)
    fmt.Printf("Data: %+v\n", response.Data)
}
```

---

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
    "url": "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts"
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=go&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=go&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=go&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=go&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
