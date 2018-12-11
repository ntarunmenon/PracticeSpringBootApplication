package org.practice.api.tasks.exception;

public class NotFoundException extends RuntimeException{
    private Long id;

    public NotFoundException(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
