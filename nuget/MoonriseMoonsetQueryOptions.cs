using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.MoonriseMoonset
{
    /// <summary>
    /// Query options for the Moonrise Moonset API
    /// </summary>
    public class MoonriseMoonsetQueryOptions
    {
        /// <summary>
        /// The latitude of the location
        /// Example: 37.7749
        /// </summary>
        [JsonProperty("lat")]
        public string Lat { get; set; }

        /// <summary>
        /// The longitude of the location
        /// Example: -122.4194
        /// </summary>
        [JsonProperty("lon")]
        public string Lon { get; set; }

        /// <summary>
        /// The date to get the moonrise and moonset times for (MM-dd-yyyy)
        /// Example: 12-02-2025
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }
    }
}
