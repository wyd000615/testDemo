/*
package com.other;



import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.Reader;
import java.lang.reflect.Type;


public class GsonUtils {
    private static final ThreadLocal<Gson> threadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Gson> threadLocalTwo = new ThreadLocal<>();
    private static final Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();

    public static Gson getGsonReplice() {
        Gson gson = threadLocalTwo.get();
        if (gson == null) {
            GsonBuilder gsonBuilder = new  GsonBuilder().setPrettyPrinting().serializeNulls();
            //注册自定义String的适配器
            gsonBuilder.registerTypeAdapter(String.class, new StringNullAdapter());
            gson = gsonBuilder.create();
            threadLocalTwo.set(gson);
        }

        return gson;
    }

    public static Gson getGson() {
        Gson gson = threadLocal.get();
        if (gson == null) {
            GsonBuilder gsonBuilder = new  GsonBuilder().setPrettyPrinting().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            //注册自定义String的适配器
            gsonBuilder.registerTypeAdapter(String.class, new StringNullAdapter());
            gson = gsonBuilder.create();
            threadLocal.set(gson);
        }

        return gson;
    }

    public static Gson getGsonPretty() {
        return gsonPretty;
    }

    public static JsonElement toJsonTree(Object src) {
        return getGson().toJsonTree(src);
    }

    public static JsonElement toJsonTree(Object src, Type typeOfSrc) {
        return getGson().toJsonTree(src, typeOfSrc);
    }

    public static String toJson(Object src) {
        return getGson().toJson(src);
    }

    public static String toJson(Object src, Type typeOfSrc) {
        return getGson().toJson(src, typeOfSrc);
    }

    public static void toJson(Object src, Appendable writer) throws JsonIOException {
        getGson().toJson(src, writer);
    }

    public static void toJson(Object src, Type typeOfSrc, Appendable writer) throws JsonIOException {
        getGson().toJson(src, typeOfSrc, writer);
    }

    public static void toJson(Object src, Type typeOfSrc, JsonWriter writer) throws JsonIOException {
        getGson().toJson(src, typeOfSrc, writer);
    }

    public static String toJson(JsonElement jsonElement) {
        return getGson().toJson(jsonElement);
    }

    public static void toJson(JsonElement jsonElement, Appendable writer) throws JsonIOException {
        getGson().toJson(jsonElement, writer);
    }

    public static void toJson(JsonElement jsonElement, JsonWriter writer) throws JsonIOException {
        getGson().toJson(jsonElement, writer);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return getGson().fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) throws JsonSyntaxException {
        return getGson().fromJson(json, typeOfT);
    }

    public static <T> T fromJson(Reader json, Class<T> classOfT) throws JsonSyntaxException, JsonIOException {
        return getGson().fromJson(json, classOfT);
    }

    public static <T> T fromJson(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return getGson().fromJson(json, typeOfT);
    }

    public static <T> T fromJson(JsonReader reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return getGson().fromJson(reader, typeOfT);
    }

    public static <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
        return getGson().fromJson(json, classOfT);
    }

    public static <T> T fromJson(JsonElement json, Type typeOfT) throws JsonSyntaxException {
        return getGson().fromJson(json, typeOfT);
    }
}
*/
