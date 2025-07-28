package com.ryu.todo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoResponseDTO {
    private Long id;
    private String title;
    private boolean completed;
}
