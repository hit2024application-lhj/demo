package org.example.myapp.Vo;

import lombok.Data;
import org.example.myapp.bean.User;

import java.util.Objects;
import java.util.StringJoiner;

@Data
public class UserVo {

    private Integer userId;

    /**
     *
     */
    private String userName;


    public UserVo (User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVo userVo = (UserVo) o;
        return Objects.equals(userId, userVo.userId) && Objects.equals(userName, userVo.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", getClass().getSimpleName() + "[", "]")
                .add("userId=" + getUserId())
                .add("userName='" + getUserName() + "'")
                .toString();
    }
}
