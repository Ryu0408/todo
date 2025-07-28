package com.ryu.todo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoRequestDTO {
    private String title;
    private boolean completed;
}
