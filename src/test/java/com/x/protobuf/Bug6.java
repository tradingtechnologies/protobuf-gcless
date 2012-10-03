// Generated by the protocol buffer gcless compiler.  DO NOT EDIT!
package com.x.protobuf;

import java.io.IOException;

public final class Bug6 {
	private Bug6() {
	}

	public static class A {
		private java.util.List<String> Entry;
		private boolean hasEntry;

		public boolean hasEntry() {
			return hasEntry;
		}

		public java.util.List<String> getEntry() {
			return Entry;
		}

		public A setEntry(java.util.List<String> Entry) {
			this.Entry = Entry;
			this.hasEntry = true;
			return this;
		}

		public String getEntry(int index) {
			return this.Entry.get(index);
		}

		public int getEntryCount() {
			return this.Entry.size();
		}

		public A setEntry(int index, String value) {
			this.Entry.set(index, value);
			return this;
		}

		public A addEntry(String value) {
			if (this.Entry == null) {
				this.Entry = new java.util.ArrayList<String>();
			}
			this.Entry.add(value);
			return this;
		}

		public A addAllEntry(java.lang.Iterable<? extends String> values) {
			if (this.Entry == null) {
				this.Entry = new java.util.ArrayList<String>();
			}
			if (values instanceof java.util.Collection) {
				@SuppressWarnings("unsafe")
				final java.util.Collection<? extends String> collection = (java.util.Collection<? extends String>) values;
				this.Entry.addAll(collection);
			} else {
				for (final String value : values) {
					this.Entry.add(value);
				}
			}
			this.hasEntry = true;
			return this;
		}

		public A clearEntry() {
			this.hasEntry = false;
			this.Entry = null;
			return this;
		}

		private int Entry2;
		private boolean hasEntry2;

		public boolean hasEntry2() {
			return hasEntry2;
		}

		public int getEntry2() {
			return Entry2;
		}

		public A setEntry2(int Entry2) {
			this.Entry2 = Entry2;
			this.hasEntry2 = true;
			return this;
		}
	}

	public static class ASerializer {
		public static byte[] serialize(com.x.protobuf.Bug6.A message) {
			try {
				int totalSize = 0;
				byte[] entryBuffer = null;
				if (message.hasEntry()) {
					java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
					for (int i = 0; i < message.getEntry().size(); i++) {
						ProtobufOutputStream.writeString(32904, message.getEntry().get(i), baos);
					}
					entryBuffer = baos.toByteArray();
					totalSize += entryBuffer.length;
				}
				if (message.hasEntry2()) {
					totalSize += ProtobufOutputStream.computeInt32Size(32902, message.getEntry2());
				}
				final byte[] result = new byte[totalSize];
				int position = 0;
				if (message.hasEntry()) {
					position = ProtobufOutputStream.writeRawBytes(entryBuffer, result, position);
				}
				if (message.hasEntry2()) {
					position = ProtobufOutputStream.writeInt32(32902, message.getEntry2(), result, position);
				}
				ProtobufOutputStream.checkNoSpaceLeft(result, position);
				return result;
			} catch (IOException e) {
				throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
			}
		}

		public static void serialize(com.x.protobuf.Bug6.A message, java.io.OutputStream os) {
			try {
				if (message.hasEntry()) {
					for (int i = 0; i < message.getEntry().size(); i++) {
						ProtobufOutputStream.writeString(32904, message.getEntry().get(i), os);
					}
				}
				if (message.hasEntry2()) {
					ProtobufOutputStream.writeInt32(32902, message.getEntry2(), os);
				}
			} catch (IOException e) {
				throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
			}
		}

		public static com.x.protobuf.Bug6.A parseFrom(byte[] data) throws java.io.IOException {
			com.x.protobuf.Bug6.A message = new com.x.protobuf.Bug6.A();
			CurrentCursor cursor = new CurrentCursor();
			while (true) {
				int tag = ProtobufInputStream.readTag(data, cursor);
				switch (tag) {
				case 0:
					return message;
				default:
					ProtobufInputStream.skipUnknown(tag, data, cursor);
					break;
				case 32904:
					if (message.getEntry() == null || message.getEntry().isEmpty()) {
						message.setEntry(new java.util.ArrayList<String>());
					}
					message.getEntry().add(ProtobufInputStream.readString(data, cursor));
					break;
				case 32902:
					message.setEntry2(ProtobufInputStream.readInt32(data, cursor));
					break;
				}
			}
		}

		public static com.x.protobuf.Bug6.A parseFrom(byte[] data, int offset, int length) throws java.io.IOException {
			com.x.protobuf.Bug6.A message = new com.x.protobuf.Bug6.A();
			CurrentCursor cursor = new CurrentCursor();
			cursor.addToPosition(offset);
			cursor.setProcessUpToPosition(offset + length);
			while (true) {
				int tag = ProtobufInputStream.readTag(data, cursor);
				switch (tag) {
				case 0:
					return message;
				default:
					ProtobufInputStream.skipUnknown(tag, data, cursor);
					break;
				case 32904:
					if (message.getEntry() == null || message.getEntry().isEmpty()) {
						message.setEntry(new java.util.ArrayList<String>());
					}
					message.getEntry().add(ProtobufInputStream.readString(data, cursor));
					break;
				case 32902:
					message.setEntry2(ProtobufInputStream.readInt32(data, cursor));
					break;
				}
			}
		}

		public static com.x.protobuf.Bug6.A parseFrom(java.io.InputStream is) throws java.io.IOException {
			com.x.protobuf.Bug6.A message = new com.x.protobuf.Bug6.A();
			CurrentCursor cursor = new CurrentCursor();
			while (true) {
				int tag = ProtobufInputStream.readTag(is, cursor);
				switch (tag) {
				case 0:
					return message;
				default:
					ProtobufInputStream.skipUnknown(tag, is, cursor);
					break;
				case 32904:
					if (message.getEntry() == null || message.getEntry().isEmpty()) {
						message.setEntry(new java.util.ArrayList<String>());
					}
					message.getEntry().add(ProtobufInputStream.readString(is, cursor));
					break;
				case 32902:
					message.setEntry2(ProtobufInputStream.readInt32(is, cursor));
					break;
				}
			}
		}

		public static com.x.protobuf.Bug6.A parseFrom(java.io.InputStream is, int offset, int length) throws java.io.IOException {
			com.x.protobuf.Bug6.A message = new com.x.protobuf.Bug6.A();
			CurrentCursor cursor = new CurrentCursor();
			cursor.addToPosition(offset);
			cursor.setProcessUpToPosition(offset + length);
			while (true) {
				int tag = ProtobufInputStream.readTag(is, cursor);
				switch (tag) {
				case 0:
					return message;
				default:
					ProtobufInputStream.skipUnknown(tag, is, cursor);
					break;
				case 32904:
					if (message.getEntry() == null || message.getEntry().isEmpty()) {
						message.setEntry(new java.util.ArrayList<String>());
					}
					message.getEntry().add(ProtobufInputStream.readString(is, cursor));
					break;
				case 32902:
					message.setEntry2(ProtobufInputStream.readInt32(is, cursor));
					break;
				}
			}
		}
	}
}
