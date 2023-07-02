package com.sourcepoint.sourcepointkmm

import com.sourcepoint.sourcepointkmm.network.SourcepointClient
import com.sourcepoint.sourcepointkmm.storage.Repository

class SourcepointCoordinator(platform: Platform) {
    private val spClient = SourcepointClient()
    private val repository = Repository(platform)

    suspend fun greet(): String {
        val metaDataResponse = spClient.getMetaData()
        val message = """
            The return of /meta-data is:
            ${spClient.getMetaData()}
            
            The cached version of /meta-data is:
            ${repository.cachedMetaData}
        """
        repository.cachedMetaData = metaDataResponse
        return message
    }
}