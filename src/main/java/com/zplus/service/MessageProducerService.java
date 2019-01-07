package com.ihzsr.monitor.jar.service;

import java.util.Map;

public interface MessageProducerService
{
    void sendServerMessage(Map<String, Object> map) throws Exception;

    void sendWebMessage(Map<String, Object> map) throws Exception;
}
