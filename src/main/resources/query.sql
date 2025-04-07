UPDATE job_actions
SET Resource =
    CASE
        WHEN name = 'BcqLevelOptimizer' THEN '/opt/optimizer?jobId=[JOB_ID]&runId=[RUN_ID]'
        WHEN name = 'BiddingOptimizer' THEN 'bidding?jobId=[JOB_ID]&runId=[RUN_ID]'
        WHEN name = 'DapExtraction' THEN 'dap?jobId=[JOB_ID]&runId=[RUN_ID]'
        WHEN name = 'PlantCapacityCalculator' THEN 'pcc?jobId=[JOB_ID]&runId=[RUN_ID]'
        WHEN name = 'TS_Regression' THEN '/ai/ts/regression?v=2&jobId=[JOB_ID]'
        WHEN name = 'TS_Classification' THEN '/ai/ts/classification?v=2&jobId=[JOB_ID]'
        WHEN name = 'TS_DataProcessing' THEN '/ai/ts/dataprocessing?v=2&jobId=[JOB_ID]'
        WHEN name = 'BillCalculator' THEN '/back-office/bill-calculator/execute/[JOB_ID]/[RUN_ID]'
        WHEN name = 'BillCalculator' THEN '/back-office/rate-calculator/execute/[JOB_ID]/[RUN_ID]'
        WHEN name = 'MeterCalculator' THEN '/back-office/meter-calculator/execute/[JOB_ID]/[RUN_ID]'
        WHEN name = 'ESSOptimizer' THEN '/opt/ESSOptimizer?jobId=[JOB_ID]&runId=[RUN_ID]'
        WHEN name = 'DataImporter' THEN '/datahub/main/uploader-fetcher/configure/[JOB_ID]'
        WHEN name = 'OfferStack' THEN '/opt/offerStack?jobId=[JOB_ID]&runId=[RUN_ID]'
        WHEN name = 'Profile Calculator' THEN '/ai/ts/profile-calculator?jobId=[JOB_ID]&runId=[RUN_ID]'
        WHEN name = 'BiddingOptimizerWDC' THEN '/opt/biddingoptimizerWDC?jobId=[JOB_ID]&runId=[RUN_ID]'
        WHEN name = 'BCQLineRentalOptimizer' THEN '/opt/bcq-optimizer?jobId=[JOB_ID]&runId=[RUN_ID]'
    END
-- select
--     *
-- from
--     job_actions
WHERE
    name IN (
        'BcqLevelOptimizer',
        'BiddingOptimizer',
        'DapExtraction',
        'PlantCapacityCalculator',
        'TS_Regression',
        'TS_Classification',
        'TS_DataProcessing',
        'BillCalculator',
        'BillCalculator',
        'MeterCalculator',
        'ESSOptimizer',
        'DataImporter',
        'OfferStack',
        'Profile Calculator',
        'BiddingOptimizerWDC',
        'BCQLineRentalOptimizer'
);
