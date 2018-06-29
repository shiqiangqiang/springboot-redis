//package com.sqq.common;
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.core.serializer.support.DeserializingConverter;
//import org.springframework.core.serializer.support.SerializingConverter;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.SerializationException;
///**
// * 实现对象的序列化接口
// * @author PC
// *
// */
//public class RedisObjectSerializer implements RedisSerializer<Object> {
//	
//	private Converter<Object, byte[]> serializer = new SerializingConverter();
//	private Converter<byte[], Object> deserializer = new DeserializingConverter();
//	
//	static final byte[] EMPTY_ARRAY = new byte[0];
//	
//	@Override
//	public Object deserialize(byte[] bytes) {
//		if (isEmpty(bytes)) {
//			return null;
//		}
//		try {
//			return deserializer.convert(bytes);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw new SerializationException("Cannot deserialize", ex);
//		}
//	}
//
//	@Override
//	public byte[] serialize(Object object) throws SerializationException {
//		if (object == null) {
//			return EMPTY_ARRAY;
//		}
//		try {
//			return serializer.convert(object);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return EMPTY_ARRAY;
//		}
//	}
//	
//	private boolean isEmpty(byte[] data) {
//		return (data.length==0 || data == null);
//	}
//
//}
