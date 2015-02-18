        QueryStringBuilder queryString = new QueryStringBuilder(request.getQueryString());
        
        // Add or overwrite attributes with new values
        queryString.put("ticketId", 255);
        queryString.put("office", "Customer Service");
        
        // Use the new queryString
        String href = request.getContextPath() + "/tickets?" + queryString;
        
