package com.fsd.core.services.libraryservice.controllers;

import com.fsd.core.services.libraryservice.models.dto.*;
import com.fsd.core.services.libraryservice.services.LibraryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiParams;
import org.jsondoc.core.annotation.ApiQueryParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@Api(value="library management tasks", description="Operations regarding library books management")
public class LibraryController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String LIBRARY_CONTROLLER = "LibraryController";

    @Autowired
    LibraryService libraryService;

    @ApiOperation(value = "Issues a book to the user",response = IssueBookResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response OK with IssueBookResponse as Response", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Input Exception", response = VndErrors.class),
            @ApiResponse(code = 401, message = "Unauthorized Exception", response = VndErrors.class),
            @ApiResponse(code = 404, message = "Resource Not Found Exception", response = VndErrors.class),
            @ApiResponse(code = 500, message = "Internal Service Exception", response = VndErrors.class)

    })
    @PostMapping("/issueBook")
    public ResponseEntity<IssueBookResponse> issueBook(@RequestBody(required = true) IssueBookRequest issueBookRequest) {
        libraryService.issueBook(issueBookRequest.getBookId(), issueBookRequest.getUserId());

        return ResponseEntity.ok().body(new IssueBookResponse(issueBookRequest.getUserId(), issueBookRequest.getBookId()));
    }

    @ApiOperation(value = "Releases a book from the user",response = ReleaseBookResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response OK with IssueBookResponse as Response", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Input Exception", response = VndErrors.class),
            @ApiResponse(code = 401, message = "Unauthorized Exception", response = VndErrors.class),
            @ApiResponse(code = 404, message = "Resource Not Found Exception", response = VndErrors.class),
            @ApiResponse(code = 500, message = "Internal Service Exception", response = VndErrors.class)

    })
    @PostMapping("/releaseBook")
    public ResponseEntity<ReleaseBookResponse> releaseBook(@RequestBody ReleaseBookRequest releaseBookRequest) {
        libraryService.releaseBook(releaseBookRequest.getBookId(), releaseBookRequest.getUserId());
        return ResponseEntity.ok().body(new ReleaseBookResponse(releaseBookRequest.getUserId(), releaseBookRequest.getBookId()));
    }
}
