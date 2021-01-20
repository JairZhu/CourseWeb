package org.jairzhu.coursewebserver.domain;

import java.util.Objects;

public class Assignment {
    private String title;
    private String content;
    private String writer;
    private String time;

    @Override
    public String toString() {
        return "assignment{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assignment)) return false;
        Assignment that = (Assignment) o;
        return Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(writer, that.writer) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, writer, time);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
