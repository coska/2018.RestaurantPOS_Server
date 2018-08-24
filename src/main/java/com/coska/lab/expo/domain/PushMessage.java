package com.coska.lab.expo.domain;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class PushMessage {

	private String to;
	private MessageType messageType;
	private String title;
	private String body;
	private Map<String, Object> dataMap = null;

	public PushMessage() {

	}

	public PushMessage(MessageType messageType) {
		this.messageType=  messageType;
		this.dataMap = new HashMap<>();
		dataMap.put("ACTION", messageType.getName());
	}

	@JsonInclude(Include.NON_NULL)
	private String data;

	@JsonInclude(Include.NON_NULL)
	private String sound;

	@JsonInclude(Include.NON_NULL)
	private Integer ttl;

	@JsonInclude(Include.NON_NULL)
	private Integer expiration;

	private String priority = "default";

	@JsonInclude(Include.NON_NULL)
	private Integer badge;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		dataMap.put("TITLE", title);
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Object getData() {
		return dataMap;
	}

	public void addData(String key, Object value) {
		dataMap.put(key, value);
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public Integer getTtl() {
		return ttl;
	}

	public void setTtl(Integer ttl) {
		this.ttl = ttl;
	}

	public Integer getExpiration() {
		return expiration;
	}

	public void setExpiration(Integer expiration) {
		this.expiration = expiration;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Integer getBadge() {
		return badge;
	}

	public void setBadge(Integer badge) {
		this.badge = badge;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

}
