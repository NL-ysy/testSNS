package com.avocado.moin.media.repository;

import com.avocado.moin.media.domain.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileRepository extends JpaRepository<UploadFile, Integer> {
    public UploadFile findOneByFileName(String fileName);
}
