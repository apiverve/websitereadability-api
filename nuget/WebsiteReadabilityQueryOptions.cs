using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.WebsiteReadability
{
    /// <summary>
    /// Query options for the Website Readability API
    /// </summary>
    public class WebsiteReadabilityQueryOptions
    {
        /// <summary>
        /// The URL of the web page to analyze
        /// Example: https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts
        /// </summary>
        [JsonProperty("url")]
        public string Url { get; set; }
    }
}
