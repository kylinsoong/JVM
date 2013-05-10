package com.kylin.jvm.lab.heap.mat;

public class BeanSerializer {
	
	private DocResponse response;

	public DocResponse getResponse() {
		return response;
	}

	public void setResponse(DocResponse response) {
		this.response = response;
	}
	
	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	
}
