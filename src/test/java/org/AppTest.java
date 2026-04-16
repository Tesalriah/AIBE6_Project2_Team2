package org;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AppTest {

    @Test
    @DisplayName("등록")
    void t1() {
        String rs = AppTestRunner.run("""
                write
                제목1
                내용1
                """);

        assertThat(rs)
                .contains("명령어: ")
                .contains("제목: ")
                .contains("내용: ");
    }

    @Test
    @DisplayName("목록")
    void t2() {
        String rs = AppTestRunner.run("""
                write
                제목1
                내용1
                write
                제목2
                내용2
                list
                """);

        assertThat(rs)
                .contains("제목2");
    }

    @Test
    @DisplayName("상세")
    void t3() {
        String rs = AppTestRunner.run("""
                write
                제목1
                내용1
                write
                제목2
                내용2
                detail 2
                """);

        assertThat(rs)
                .contains("제목 : 제목2")
                .contains("내용 : 내용2");
    }

    @Test
    @DisplayName("삭제 1")
    void t4 () {
        String rs = AppTestRunner.run("""
                write
                제목1
                내용1
                write
                제목2
                내용2
                delete 1
                list
                """);

        assertThat(rs)
                .contains("2    | 제목2      |")
                .doesNotContain("1    | 제목1      |");
    }

}
