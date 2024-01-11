package com.gdn.indeniza.dtos;

import com.gdn.indeniza.entities.enums.Role;

public record RegisterDTO (String name, String login, String password, Role role){

}
