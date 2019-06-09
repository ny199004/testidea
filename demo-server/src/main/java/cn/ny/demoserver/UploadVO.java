package cn.ny.demoserver;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author nieye
 * @create 2019-06-03 22:02
 */
public class UploadVO {
    private   String name;
    private   int age;
    private MultipartFile file;

    public UploadVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "UploadVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", file=" + file +
                '}';
    }
}
