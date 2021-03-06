/*
 * Copyright (c) 2015 LingoChamp Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liulishuo.filedownloader.services;


import com.liulishuo.filedownloader.model.FileDownloadModel;

import java.util.List;

/**
 * The helper for handling all operations with the filedownloader database.
 */
interface IFileDownloadDBHelper {

    /**
     * @param id download id
     */
    FileDownloadModel find(final int id);


    void insert(final FileDownloadModel downloadModel);

    void update(final FileDownloadModel downloadModel);

    void update(final List<FileDownloadModel> downloadModelList);

    boolean remove(final int id);

    void updateConnected(final FileDownloadModel model, final long total, final String etag,
                         final String fileName);

    void updateProgress(final FileDownloadModel model, final long soFar);

    void updateError(final FileDownloadModel model, final Throwable throwable, final long sofar);

    void updateRetry(final FileDownloadModel model, final Throwable throwable);

    void updateComplete(final FileDownloadModel model, final long total);

    void updatePause(final FileDownloadModel model, final long sofar);

    void updatePending(final FileDownloadModel model);
}
