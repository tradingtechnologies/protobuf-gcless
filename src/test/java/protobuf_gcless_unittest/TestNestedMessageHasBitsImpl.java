package protobuf_gcless_unittest;

public class TestNestedMessageHasBitsImpl implements protobuf_gcless_unittest.UnittestProto.TestNestedMessageHasBits {
private protobuf_gcless_unittest.UnittestProto.TestNestedMessageHasBits.NestedMessage Optional_nested_message;
private boolean hasOptional_nested_message;
public boolean hasOptional_nested_message() {
return hasOptional_nested_message;
}
public protobuf_gcless_unittest.UnittestProto.TestNestedMessageHasBits.NestedMessage getOptional_nested_message() {
return Optional_nested_message;
}
public void setOptional_nested_message(protobuf_gcless_unittest.UnittestProto.TestNestedMessageHasBits.NestedMessage Optional_nested_message) {
this.Optional_nested_message = Optional_nested_message;
this.hasOptional_nested_message = true;
}
public protobuf_gcless_unittest.UnittestProto.TestNestedMessageHasBits create() {
return new TestNestedMessageHasBitsImpl();
}
}
