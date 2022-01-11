package com.rabbitdemo.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserMessage implements Serializable {
//Serializable will allow rabbitMq to Publish the object as a binary
    private String userName;
    private String userMessage;

}
