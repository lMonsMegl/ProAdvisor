package com.proadvisor.model.builder;

import com.proadvisor.model.entity.common.Comment;
import com.proadvisor.model.entity.common.User;
import com.proadvisor.model.entity.item.Item;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ItemBuilder<T extends Item, B> {
    
    private T item;
    
    public ItemBuilder(T item) {
        this.item = item;
    }
    
    public B id(Long id) {
        item.setId(id);
        return (B) this;
    }
    
    public B name(String name) {
        item.setName(name);
        return (B) this;
    }
    
    public B description(String description) {
        item.setDescription(description);
        return (B) this;
    }
    
    public CommentBuilder comment() {
        return new CommentBuilder();
    }
    
    public B mainImage(String mainImage) {
        item.setMainImage(mainImage);
        return (B) this;
    }
    
    public B images(List<String> images) {
        item.setImages(images);
        return (B) this;
    }
    
    public T build() {
        return item;
    }
    
    public class CommentBuilder {
        
        private Comment comment = new Comment();
        
        public CommentBuilder id(Long id) {
            comment.setId(id);
            return this;
        }
        public CommentBuilder title(String title) {
            comment.setTitle(title);
            return this;
        }
        public CommentBuilder text(String text) {
            comment.setText(text);
            return this;
        }
        public CommentBuilder rating(int rating) {
            comment.setRating(rating);
            return this;
        }
        public CommentBuilder createdDateTime(ZonedDateTime createdDateTime) {
            comment.setCreatedDateTime(createdDateTime);
            return this;
        }
        public CommentBuilder user(User user) {
            comment.setUser(user);
            return this;
        }
        
        public B done() {
            if(item.getComments() == null) {
                item.setComments(new ArrayList<>());
            }
            item.getComments().add(comment);
            comment.setItem(item);
            return (B) ItemBuilder.this;
        }
    }
    
}
