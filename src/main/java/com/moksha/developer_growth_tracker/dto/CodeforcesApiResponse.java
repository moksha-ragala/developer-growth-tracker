package com.moksha.developer_growth_tracker.dto;

import java.util.List;

public class CodeforcesApiResponse {

    private String status;
    private List<CodeforcesResponse> result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CodeforcesResponse> getResult() {
        return result;
    }

    public void setResult(
            List<CodeforcesResponse> result) {

        this.result = result;
    }
}