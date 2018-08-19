package com.coska.lab.expo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class PushMessage {

	private String to;
	private MessageType messageType;
	private String title;
	private String body;

	public PushMessage() {

	}

	public PushMessage(MessageType messageType) {
		this.messageType=  messageType;
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
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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
