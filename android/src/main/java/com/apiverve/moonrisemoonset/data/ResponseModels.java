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
//     MoonriseMoonsetData data = Converter.fromJsonString(jsonString);

package com.apiverve.moonrisemoonset.data;

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

    public static MoonriseMoonsetData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(MoonriseMoonsetData obj) throws JsonProcessingException {
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
        reader = mapper.readerFor(MoonriseMoonsetData.class);
        writer = mapper.writerFor(MoonriseMoonsetData.class);
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

// MoonriseMoonsetData.java

package com.apiverve.moonrisemoonset.data;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

public class MoonriseMoonsetData {
    private Coordinates coordinates;
    private String phase;
    private OffsetDateTime moonrise;
    private OffsetDateTime moonset;
    private boolean moonAlwaysUp;
    private boolean moonAlwaysDown;

    @JsonProperty("coordinates")
    public Coordinates getCoordinates() { return coordinates; }
    @JsonProperty("coordinates")
    public void setCoordinates(Coordinates value) { this.coordinates = value; }

    @JsonProperty("phase")
    public String getPhase() { return phase; }
    @JsonProperty("phase")
    public void setPhase(String value) { this.phase = value; }

    @JsonProperty("moonrise")
    public OffsetDateTime getMoonrise() { return moonrise; }
    @JsonProperty("moonrise")
    public void setMoonrise(OffsetDateTime value) { this.moonrise = value; }

    @JsonProperty("moonset")
    public OffsetDateTime getMoonset() { return moonset; }
    @JsonProperty("moonset")
    public void setMoonset(OffsetDateTime value) { this.moonset = value; }

    @JsonProperty("moonAlwaysUp")
    public boolean getMoonAlwaysUp() { return moonAlwaysUp; }
    @JsonProperty("moonAlwaysUp")
    public void setMoonAlwaysUp(boolean value) { this.moonAlwaysUp = value; }

    @JsonProperty("moonAlwaysDown")
    public boolean getMoonAlwaysDown() { return moonAlwaysDown; }
    @JsonProperty("moonAlwaysDown")
    public void setMoonAlwaysDown(boolean value) { this.moonAlwaysDown = value; }
}

// Coordinates.java

package com.apiverve.moonrisemoonset.data;

import com.fasterxml.jackson.annotation.*;

public class Coordinates {
    private double latitude;
    private double longitude;

    @JsonProperty("latitude")
    public double getLatitude() { return latitude; }
    @JsonProperty("latitude")
    public void setLatitude(double value) { this.latitude = value; }

    @JsonProperty("longitude")
    public double getLongitude() { return longitude; }
    @JsonProperty("longitude")
    public void setLongitude(double value) { this.longitude = value; }
}