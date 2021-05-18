CREATE TABLE IF NOT EXISTS step
(
  device_id VARCHAR,
  device_sync BIGINT,
  sync_timestamp timestamptz,
  steps_count INTEGER,
  PRIMARY KEY (device_id, device_sync)
);
