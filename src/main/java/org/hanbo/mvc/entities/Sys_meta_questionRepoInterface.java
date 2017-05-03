package org.hanbo.mvc.entities;

import java.util.List;

public interface Sys_meta_questionRepoInterface {
    void indexSys_meta_question() throws Exception;
    List<Sys_meta_question> searchForBook(String searchText) throws Exception;
}
