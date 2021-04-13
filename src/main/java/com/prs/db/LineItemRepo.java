package com.prs.db;
import java.util.List;

//foreign key to request, foreign key to product
import org.springframework.data.jpa.repository.JpaRepository;

import com.prs.business.LineItem;
import com.prs.business.Request;


public interface LineItemRepo extends JpaRepository<LineItem, Integer>{
List<LineItem> findByRequestId(Request r);
}
