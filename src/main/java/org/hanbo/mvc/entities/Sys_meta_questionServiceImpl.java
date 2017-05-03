package org.hanbo.mvc.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class Sys_meta_questionServiceImpl implements Sys_meta_questionService {
    private Sys_meta_questionRepoInterface _repo;

    @Override
    @Transactional(readOnly = true)
    public void indexSys_meta_question() throws Exception {
        _repo.indexSys_meta_question();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sys_meta_question> searchForBook(String searchText) throws Exception {
        return _repo.searchForBook(searchText);
    }

    @Autowired
    public void set_repo(Sys_meta_questionRepoInterface _repo) {
        this._repo = _repo;
    }
}
