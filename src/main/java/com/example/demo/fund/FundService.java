package com.example.demo.fund;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.fund.Fund;
import com.example.demo.fund.FundRepository;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundService {

    @Autowired
    private FundRepository fundRepository;

    // Save operation
    public Fund createFund(Fund fund)
    {
        return fundRepository.save(fund);
    }

    // Read operation
    public List<Fund> getFunds()
    {
        return (List<Fund>)
                fundRepository.findAll();
    }

    // Update operation
    public Fund
    updateFund(Fund fund,
                     Long id)
    {
        Fund fundDB
                = fundRepository.findById(id)
                .get();

        if (Objects.nonNull(fund.getName())
                && !"".equalsIgnoreCase(
                fund.getName())) {
            fundDB.setName(
                    fund.getName());
        }

        if (Objects.nonNull(
                fund.getYield())) {
            fundDB.setYield(
                    fund.getYield());
        }

        return fundRepository.save(fundDB);
    }

    // Delete operation
    public void deleteFund(Long fundId)
    {
        fundRepository.deleteById(fundId);
    }
}
