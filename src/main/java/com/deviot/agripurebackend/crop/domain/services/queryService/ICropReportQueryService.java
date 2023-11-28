package com.deviot.agripurebackend.crop.domain.services.queryService;

import com.deviot.agripurebackend.crop.domain.model.aggregates.CropReport;
import com.deviot.agripurebackend.crop.domain.model.queries.GetCropReportByIdQuery;
import com.deviot.agripurebackend.crop.domain.model.queries.GetCropReportsByCropIdQuery;

import java.util.List;

public interface ICropReportQueryService {

    CropReport handle(GetCropReportByIdQuery getCropReportByIdQuery);
    List<CropReport> handle (GetCropReportsByCropIdQuery getCropReportsByCropIdQuery);
}
