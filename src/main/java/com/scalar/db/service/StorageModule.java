package com.scalar.db.service;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.scalar.db.api.DistributedStorage;
import com.scalar.db.config.DatabaseConfig;
import com.scalar.db.storage.cassandra.Cassandra;

public class StorageModule extends AbstractModule {
  private final DatabaseConfig config;

  public StorageModule(DatabaseConfig config) {
    this.config = config;
  }

  @Override
  protected void configure() {
    bind(DistributedStorage.class).to(Cassandra.class).in(Singleton.class);
  }

  @Provides
  Cassandra provideCassandra() {
    return new Cassandra(config);
  }
}
