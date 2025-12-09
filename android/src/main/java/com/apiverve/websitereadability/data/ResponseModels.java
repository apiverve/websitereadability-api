// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     WebsiteReadabilityData data = Converter.fromJsonString(jsonString);

package com.apiverve.websitereadability.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static WebsiteReadabilityData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(WebsiteReadabilityData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(WebsiteReadabilityData.class);
        writer = mapper.writerFor(WebsiteReadabilityData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// WebsiteReadabilityData.java

package com.apiverve.websitereadability.data;

import com.fasterxml.jackson.annotation.*;

public class WebsiteReadabilityData {
    private double fleschReadingEase;
    private String fleschReadingEaseText;
    private double fleschKincaidGrade;
    private double gunningFog;
    private double colemanLiauIndex;
    private double smogIndex;
    private double automatedReadabilityIndex;
    private long daleChallReadabilityScore;
    private String daleChallReadabilityScoreText;
    private String url;

    @JsonProperty("fleschReadingEase")
    public double getFleschReadingEase() { return fleschReadingEase; }
    @JsonProperty("fleschReadingEase")
    public void setFleschReadingEase(double value) { this.fleschReadingEase = value; }

    @JsonProperty("fleschReadingEaseText")
    public String getFleschReadingEaseText() { return fleschReadingEaseText; }
    @JsonProperty("fleschReadingEaseText")
    public void setFleschReadingEaseText(String value) { this.fleschReadingEaseText = value; }

    @JsonProperty("fleschKincaidGrade")
    public double getFleschKincaidGrade() { return fleschKincaidGrade; }
    @JsonProperty("fleschKincaidGrade")
    public void setFleschKincaidGrade(double value) { this.fleschKincaidGrade = value; }

    @JsonProperty("gunningFog")
    public double getGunningFog() { return gunningFog; }
    @JsonProperty("gunningFog")
    public void setGunningFog(double value) { this.gunningFog = value; }

    @JsonProperty("colemanLiauIndex")
    public double getColemanLiauIndex() { return colemanLiauIndex; }
    @JsonProperty("colemanLiauIndex")
    public void setColemanLiauIndex(double value) { this.colemanLiauIndex = value; }

    @JsonProperty("smogIndex")
    public double getSmogIndex() { return smogIndex; }
    @JsonProperty("smogIndex")
    public void setSmogIndex(double value) { this.smogIndex = value; }

    @JsonProperty("automatedReadabilityIndex")
    public double getAutomatedReadabilityIndex() { return automatedReadabilityIndex; }
    @JsonProperty("automatedReadabilityIndex")
    public void setAutomatedReadabilityIndex(double value) { this.automatedReadabilityIndex = value; }

    @JsonProperty("daleChallReadabilityScore")
    public long getDaleChallReadabilityScore() { return daleChallReadabilityScore; }
    @JsonProperty("daleChallReadabilityScore")
    public void setDaleChallReadabilityScore(long value) { this.daleChallReadabilityScore = value; }

    @JsonProperty("daleChallReadabilityScoreText")
    public String getDaleChallReadabilityScoreText() { return daleChallReadabilityScoreText; }
    @JsonProperty("daleChallReadabilityScoreText")
    public void setDaleChallReadabilityScoreText(String value) { this.daleChallReadabilityScoreText = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }
}