package com.football_field.football_field.Servicies;

import com.football_field.football_field.Entities.Request;

public interface RequestService extends  BaseService<Request> {
    Request createRequest(Request request,Long id);
}
