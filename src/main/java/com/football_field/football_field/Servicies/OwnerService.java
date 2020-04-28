package com.football_field.football_field.Servicies;


import com.football_field.football_field.Entities.Owner;

public interface OwnerService extends BaseService<Owner> {
    Owner create(Owner owner,Long requestId);
}
