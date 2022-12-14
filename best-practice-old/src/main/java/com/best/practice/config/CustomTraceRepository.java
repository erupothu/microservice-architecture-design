package com.best.practice.config;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.stereotype.Repository;

import antlr.collections.List;

@Repository
public class CustomTraceRepository implements HttpTraceRepository {
	
	 AtomicReference<HttpTrace> lastTrace = new AtomicReference<>();

	    @Override
	    public java.util.List<HttpTrace> findAll() {
	        return Collections.singletonList(lastTrace.get());
	    }

	    @Override
	    public void add(HttpTrace trace) {
	        if ("GET".equals(trace.getRequest().getMethod())) {
	            lastTrace.set(trace);
	        }
	    }

}
