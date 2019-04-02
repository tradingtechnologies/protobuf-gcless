package com.google.code.proto.gcless;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Tokens {

	static final String PROTO_PACKAGE = "package";
	static final String SYNTAX = "syntax";
	static final String GO_PACKAGE = "go_package";
	static final String JAVA_PACKAGE = "java_package";
	static final String JAVA_OUTER_CLASSNAME = "java_outer_classname";
	static final String JAVA_MULT_FILES = "java_multiple_files";
	static final String CSHARP_NAMESPACE = "csharp_namespace";
	static final String OBJC_CLASS_PREFIX = "objc_class_prefix";
	static final String OPTIMIZE_FOR = "optimize_for";
	static final String MESSAGE = "message";
	static final String OPTIONAL_FIELD = "optional";
	static final String REPEATED_FIELD = "repeated";
	static final String REQUIRED_FIELD = "required";
	static final String BRACE_START = "{";
	static final String BRACE_END = "}";
	static final String ENUM_TOKEN = "enum";
	static final String ONEOF_TOKEN = "oneof";
	static final String SQUARE_BRACE_START = "[";
	static final String SQUARE_BRACE_END = "]";
	static final String DEFAULT = "default";
	static final String PACKED = "packed";
	static final String DEPRECATED = "deprecated";
	static final String OPTION = "option";
	static final String IMPORT_TOKEN = "import";
	static final String OPEN_PARENTHESIS = "(";
	static final String CLOSE_PARENTHESIS = ")";
	static final String EXTENSIONS = "extensions";
	static final String RESERVED = "reserved";
	static final String FIXENUM = "fixenum";
	static final String CC_ENABLE_ARENAS = "cc_enable_arenas";

	private static final Pattern IDENTIFIER_PATTERN = Pattern.compile("[a-zA-Z_]+");
	private static final Pattern MAP_PATTERN = Pattern.compile("map<[a-zA-Z_.]*");
	private static final Set<String> FIELD_TYPES = new HashSet<String>();

	static {
		FIELD_TYPES.add("int32");
		FIELD_TYPES.add("int64");
		FIELD_TYPES.add("uint32");
		FIELD_TYPES.add("uint64");
		FIELD_TYPES.add("sint32");
		FIELD_TYPES.add("sint64");
		FIELD_TYPES.add("fixed32");
		FIELD_TYPES.add("fixed64");
		FIELD_TYPES.add("sfixed32");
		FIELD_TYPES.add("sfixed64");
		FIELD_TYPES.add("float");
		FIELD_TYPES.add("double");
		FIELD_TYPES.add("bool");
		FIELD_TYPES.add("string");
		FIELD_TYPES.add("bytes");
	}

	static boolean isIdentifier(String str) {
		Matcher m = IDENTIFIER_PATTERN.matcher(str);
		return m.find();
	}

	static boolean isValidFieldType(String str) {
		if (FIELD_TYPES.contains(str)) {
			return true;
		}
		if (isIdentifier(str)) {
			return true;
		}
		return false;
	}

	static boolean isValidTag(long tag) {
		if( tag > 268435455 || tag < -268435455 ) {
			return false;
		}
		return true;
	}

        static boolean isValidMap(String str) {
		Matcher m = MAP_PATTERN.matcher(str);
		if (m.find()) {
                    return true;
                }
                return false;
        }

}
