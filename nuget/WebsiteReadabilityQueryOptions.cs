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
        /// </summary>
        [JsonProperty("url")]
        public string Url { get; set; }
    }
}
