package com.google.code.proto.gcless;

import java.util.HashSet;
import java.util.Set;

class GsonEnumHelper
{
    final String packageName;
    final String enumAdapter;

    Set<String> enums = new HashSet<String>();

    public GsonEnumHelper(String packageName, String enumAdapter)
    {
        this.packageName = packageName;
        this.enumAdapter = enumAdapter;
    }

    public void addEnum(String fullyQualifiedJavaTypeName)
    {
        this.enums.add(fullyQualifiedJavaTypeName);
    }

    public void addEnum(ProtobufEnum anEnum)
    {
        this.addEnum(anEnum.getFullyClarifiedJavaName());
    }

    private static StringBuilder initEnumConvStringBuilder(String packageName)
    {
        StringBuilder stringBuilder = new StringBuilder();


        stringBuilder.append(
                 "package " + packageName + ";\n\n" +
                 "import com.google.gson.JsonDeserializationContext;\n" +
                 "import com.google.gson.JsonDeserializer;\n" +
                 "import com.google.gson.JsonElement;\n" +
                 "import com.google.gson.JsonParseException;\n" +
                 "import java.lang.reflect.Type;\n\n" +
                 "public final class GsonHelper {\n\n" +
                 "static com.google.gson.Gson gson;\n\n" +
                 "public static com.google.gson.Gson getGson()\n" +
                 "{\n" +
                 "    if (gson == null) { gson = createBuilder().create(); } \n" +
                 "    return gson;\n" +
                 "}\n\n" +
                 "public static class CustomLongDeserializer implements JsonDeserializer<Long> {\n" +
                 "    @Override\n" +
                 "    public Long deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {\n" +
                 "        try {\n" +
                 "            return element.getAsBigInteger().longValue();\n" +
                 "        } catch (NumberFormatException e) {\n" +
                 "            throw new JsonParseException(e);\n" +
                 "        }\n" +
                 "    }\n" +
                 "}\n\n" +
                 "public static class CustomByteArrayDeserializer implements JsonDeserializer<byte[]> {\n" +
                 "    @Override\n" +
                 "    public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {\n" +
                 "        return null;\n" +
                 "    }\n" +
                 "}\n\n" +
                 "static com.google.gson.GsonBuilder createBuilder() {\n" +
                 "    com.google.gson.GsonBuilder builder = new com.google.gson.GsonBuilder();\n" +
                 "    builder\n" +
                 "        .disableHtmlEscaping()\n" +
                 "        .excludeFieldsWithoutExposeAnnotation()\n" +
                 "        .excludeFieldsWithModifiers(java.lang.reflect.Modifier.STATIC)\n" +
                 "        .registerTypeAdapter(Long.class, new com.tradingtechnologies.messaging.GsonHelper.CustomLongDeserializer())\n" +
                 "        .registerTypeAdapter(byte[].class, new com.tradingtechnologies.messaging.GsonHelper.CustomByteArrayDeserializer())\n"
        );


        return stringBuilder;
    }

    private void genGsonEnumConvCode(String anEnum, StringBuilder enumConvStringBuilder)
    {
        enumConvStringBuilder.append("\t.registerTypeAdapter(");
        enumConvStringBuilder.append(anEnum);
        enumConvStringBuilder.append(".class, new " + this.enumAdapter + "<");
        enumConvStringBuilder.append(anEnum);
        enumConvStringBuilder.append(">())\n");
    }

    @Override
    public String toString()
    {
        StringBuilder sb = initEnumConvStringBuilder(this.packageName);

        for(String e : this.enums)
        {
            genGsonEnumConvCode(e, sb);
        }

        sb.append(";\n\n");
        sb.append("return builder;\n}");
        sb.append("}");

        return sb.toString();
    }
}
